package com.vn.tb.quote.Controller.Author;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vn.tb.quote.Model.Author;
import com.vn.tb.quote.Model.Quote;
import com.vn.tb.quote.Service.AuthorService;
import com.vn.tb.quote.Service.QuoteService;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
	@Autowired
	AuthorService authorService;
	
	@Autowired
	QuoteService quoteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView Authors(ModelAndView modelAndView) {
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Author> lstAuthors = authorService.getAuthors(defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", "Authors");
		modelAndView.addObject("imageLink", "https://static.quotery.com/backgrounds/1280/author-1280.jpg");
		modelAndView.addObject("lstAuthors", lstAuthors);
		modelAndView.setViewName("authors/authors");
		return modelAndView;
	}
	
	@RequestMapping(value = "/abraham-lincoln", method = RequestMethod.GET)
	public ModelAndView AbrahamLincoln(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/abraham-lincoln");
		return modelAndView;
	}
	
	@RequestMapping(value = "/maya-angelou", method = RequestMethod.GET)
	public ModelAndView MayaAngelou(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/maya-angelou");
		return modelAndView;
	}
	
	@RequestMapping(value = "/walt-disney", method = RequestMethod.GET)
	public ModelAndView WaltDisney(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/walt-disney");
		return modelAndView;
	}
	
	@RequestMapping(value = "/martin-luther-king-jr", method = RequestMethod.GET)
	public ModelAndView MartinLutherKing(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/martin-luther-king-jr");
		return modelAndView;
	}
	
	@RequestMapping(value = "/marilyn-monroe", method = RequestMethod.GET)
	public ModelAndView MarilynMonroe(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/marilyn-monroe");
		return modelAndView;
	}
	
	@RequestMapping(value = "/mohandas-karamchand-gandhi", method = RequestMethod.GET)
	public ModelAndView MohandasKaramchandGandhi(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/mohandas-karamchand-gandhi");
		return modelAndView;
	}
	
	@RequestMapping(value = "/lao-tzu", method = RequestMethod.GET)
	public ModelAndView LaoTzu(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/lao-tzu");
		return modelAndView;
	}
	
	@RequestMapping(value = "/albert-einstein", method = RequestMethod.GET)
	public ModelAndView AlbertEinstein(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/albert-einstein");
		return modelAndView;
	}
	
	@RequestMapping(value = "/robert-frost", method = RequestMethod.GET)
	public ModelAndView RobertFrost(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/robert-frost");
		return modelAndView;
	}
	
	@RequestMapping(value = "/mark-twain", method = RequestMethod.GET)
	public ModelAndView MarkTwain(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/mark-twain");
		return modelAndView;
	}
	
	@RequestMapping(value = "/buddha", method = RequestMethod.GET)
	public ModelAndView Buddha(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/buddha");
		return modelAndView;
	}
	
	@RequestMapping(value = "/confucius", method = RequestMethod.GET)
	public ModelAndView Confucius(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/confucius");
		return modelAndView;
	}
	
	@RequestMapping(value = "/ralph-waldo-emerson", method = RequestMethod.GET)
	public ModelAndView RalphWaldoEmerson(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/ralph-waldo-emerson");
		return modelAndView;
	}
	
	@RequestMapping(value = "/eleanor-roosevelt", method = RequestMethod.GET)
	public ModelAndView EleanorRoosevelt(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/eleanor-roosevelt");
		return modelAndView;
	}
	
	@RequestMapping(value = "/william-shakespeare", method = RequestMethod.GET)
	public ModelAndView WilliamShakespeare(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/william-shakespeare");
		return modelAndView;
	}
	
	@RequestMapping(value = "/benjamin-franklin", method = RequestMethod.GET)
	public ModelAndView BenjaminFranklin(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/benjamin-franklin");
		return modelAndView;
	}
	
	@RequestMapping(value = "/aristotle", method = RequestMethod.GET)
	public ModelAndView Aristotle(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/aristotle");
		return modelAndView;
	}
	
	@RequestMapping(value = "/henry-david-thoreau", method = RequestMethod.GET)
	public ModelAndView HenryDavidThoreau(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/henry-david-thoreau");
		return modelAndView;
	}
	
	@RequestMapping(value = "/winston-churchill", method = RequestMethod.GET)
	public ModelAndView WinstonChurchill(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/winston-churchill");
		return modelAndView;
	}
	
	@RequestMapping(value = "/dalai-lama", method = RequestMethod.GET)
	public ModelAndView DalaiLama(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/dalai-lama");
		return modelAndView;
	}
	
	@RequestMapping(value = "/nelson-mandela", method = RequestMethod.GET)
	public ModelAndView NelsonMandela(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/nelson-mandela");
		return modelAndView;
	}
	
	@RequestMapping(value = "/oscar-wilde", method = RequestMethod.GET)
	public ModelAndView OscarWilde(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/oscar-wilde");
		return modelAndView;
	}
	
	@RequestMapping(value = "/bette-davis", method = RequestMethod.GET)
	public ModelAndView BetteDavis(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/bette-davis");
		return modelAndView;
	}
	
	@RequestMapping(value = "/steve-jobs", method = RequestMethod.GET)
	public ModelAndView SteveJobs(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/steve-jobs");
		return modelAndView;
	}
	
	@RequestMapping(value = "/c-s-lewis", method = RequestMethod.GET)
	public ModelAndView CSLewis(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/c-s-lewis");
		return modelAndView;
	}
	
	@RequestMapping(value = "/stephen-hawking", method = RequestMethod.GET)
	public ModelAndView StephenHawking(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/stephen-hawking");
		return modelAndView;
	}
	
	@RequestMapping(value = "/mother-teresa", method = RequestMethod.GET)
	public ModelAndView MotherTeresa(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/mother-teresa");
		return modelAndView;
	}
	
	@RequestMapping(value = "/vince-lombardi", method = RequestMethod.GET)
	public ModelAndView VinceLombardi(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/vince-lombardi");
		return modelAndView;
	}
	
	@RequestMapping(value = "/oprah-winfrey", method = RequestMethod.GET)
	public ModelAndView OprahWinfrey(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/oprah-winfrey");
		return modelAndView;
	}
	
	@RequestMapping(value = "/plato", method = RequestMethod.GET)
	public ModelAndView Plato(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/plato");
		return modelAndView;
	}
	
	@RequestMapping(value = "/warren-buffett", method = RequestMethod.GET)
	public ModelAndView WarrenBuffet(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/warren-buffett");
		return modelAndView;
	}
	
	@RequestMapping(value = "/george-carlin", method = RequestMethod.GET)
	public ModelAndView GeorgeCarlin(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/george-carlin");
		return modelAndView;
	}
	
	@RequestMapping(value = "/jerry-seinfeld", method = RequestMethod.GET)
	public ModelAndView JerrySeinfeld(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/jerry-seinfeld");
		return modelAndView;
	}
	
	@RequestMapping(value = "/j-k-rowling", method = RequestMethod.GET)
	public ModelAndView JKRowling(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/j-k-rowling");
		return modelAndView;
	}
	
	@RequestMapping(value = "/bill-gates", method = RequestMethod.GET)
	public ModelAndView BillGates(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/bill-gates");
		return modelAndView;
	}
	
	@RequestMapping(value = "/robin-williams", method = RequestMethod.GET)
	public ModelAndView RobinWilliams(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/robin-williams");
		return modelAndView;
	}
	
	@RequestMapping(value = "/helen-keller", method = RequestMethod.GET)
	public ModelAndView HelenKeller(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/helen-keller");
		return modelAndView;
	}
	
	@RequestMapping(value = "/anne-frank", method = RequestMethod.GET)
	public ModelAndView AnneFrank(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/anne-frank");
		return modelAndView;
	}
	
	@RequestMapping(value = "/walt-whitman", method = RequestMethod.GET)
	public ModelAndView WaltWhitman(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/walt-whitman");
		return modelAndView;
	}
	
	@RequestMapping(value = "/al-capone", method = RequestMethod.GET)
	public ModelAndView AlCapone(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/al-capone");
		return modelAndView;
	}
	
	@RequestMapping(value = "/jason-bacchetta", method = RequestMethod.GET)
	public ModelAndView JasonBacchetta(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/jason-bacchetta");
		return modelAndView;
	}
	
	@RequestMapping(value = "/cyril-northcote-parkinson", method = RequestMethod.GET)
	public ModelAndView CyrilNorthcoteParkinson(ModelAndView modelAndView, HttpServletRequest request) {
		String authorLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = authorService.getAuthorNameAndImage(authorLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByAuthor(authorLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("authors/cyril-northcote-parkinson");
		return modelAndView;
	}
}
