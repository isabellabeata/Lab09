package it.polito.tdp.borders.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {
	
	BordersDAO dao= new BordersDAO() ;
	Graph<Country, DefaultEdge> grafo;
	Map<Integer, Country> stati;
	List<Country> countryList= new LinkedList<Country>(dao.loadAllCountries());
	

	
	
	public String creaGrafo(int year) {
		this.grafo= new SimpleGraph<Country, DefaultEdge>(DefaultEdge.class);
		List<Border> list = this.dao.getCountryPairs(year, this.stati);
		for(Border b: list) {
			grafo.addVertex(b.getCountry1());
			grafo.addVertex(b.getCountry2());
			grafo.addEdge(b.getCountry1(), b.getCountry2());
		}
		String s="";
		s+="Numero di componenti connesse: "+this.grafo.vertexSet().size()+"\n";
		for(Country c: this.grafo.vertexSet()) {
			List<Country> vicini= Graphs.neighborListOf(this.grafo, c);
			s+=c.getStateNme()+" "+vicini.size()+"\n";
		}
		
		return s;
	}

	public Model() {
		
		this.stati=new HashMap<Integer, Country>();
		for(Country c: this.countryList) {
			
			stati.put(c.getcCode(), c);
		}
		
	}
	
	public List<Country> getAllCountry() {
		return this.dao.loadAllCountries();
		
	}
	
	public String visitaGrafo(int anno, Country partenza){
		creaGrafo(anno);
		GraphIterator<Country, DefaultEdge> visita= new BreadthFirstIterator<>(this.grafo, partenza);
		List<Country> list= new LinkedList<>();
		String s="";
		
		list.addAll(Graphs.neighborListOf(this.grafo, partenza));
		for(Country c: list) {
			s+=c.getStateNme()+"\n";
		}
			return s;
	}

}
