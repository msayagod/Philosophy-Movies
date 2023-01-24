package model;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class filmaffinityScrap {

	public Document getHTMLMovie(String title, int year) {
		Document doc = null;
		// Reemplazamos los espacios por +
		char ch = '+';
		title = title.replace(' ', ch);
		try {
			// Obtenemos el documento html de la pagina a la que nos queremos conectar
			doc = Jsoup.connect("https://www.filmaffinity.com/es/search.php?stext=" + title).get();

			String urlMovie;
			if (isSearch(doc)) {
				urlMovie = getURLMovie(doc, year);
				if (urlMovie != null) {
					doc = Jsoup.connect(urlMovie).get();
				} else
					doc = null;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}

	public MovieEntity getMovie(Document doc) {
		if (doc == null)
			return null;
		MovieEntity movie = new MovieEntity();

		Element h1 = doc.selectFirst("h1");
		Element MI = doc.selectFirst("dl");
		movie.setTitle(h1.getElementsByAttributeValue("itemprop", "name").text());
		movie.setSynopsis(MI.getElementsByAttributeValue("itemprop", "description").text());
		movie.setYear(Integer.parseInt(MI.getElementsByAttributeValue("itemprop", "datePublished").text()));
		movie.setSynopsis(MI.getElementsByAttributeValue("itemprop", "description").text());
		System.out.println(movie.getTitle());

		return movie;

	}

	public String getURLMovie(Document doc, int year) {
		String urlMovie = null;
		// Obtenemos los elementos que queremos (los de la clase "se-it" que corresponde
		// a cada pelicula)
		Elements el = doc.getElementsByClass("se-it");

		// Recorremos los elementos (peliculas)
		for (int i = 0; i < el.size(); i++) {

			// Si coincide el año con lo que buscamos, obtenemos la url de la pelicula
			if (Integer.parseInt(el.get(i).firstElementChild().text()) == year) {
				urlMovie = (el.get(i).getElementsByClass("mc-title").get(0).select("a").attr("href"));
				break;
			}
		}
		return urlMovie;
	}

	// Comprueba si la pagina es de busqueda o no (pelicula)
	public boolean isSearch(Document doc) {

		Element h1 = doc.selectFirst("h1");

		if (h1.parent().hasAttr("itemscope")) {
			return false;
		} else
			return true;

	}

}
