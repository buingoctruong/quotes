package com.vn.tb.quote.Controller.Collection;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vn.tb.quote.Model.Collection;
import com.vn.tb.quote.Model.Quote;
import com.vn.tb.quote.Service.CollectionService;
import com.vn.tb.quote.Service.QuoteService;

@RestController
@RequestMapping(value = "/collections")
public class CollectionController {
	@Autowired
	CollectionService collectionService;
	
	@Autowired
	QuoteService quoteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView Collections(ModelAndView modelAndView) {
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Collection> lstCollections = collectionService.getCollections(defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", "Collection");
		modelAndView.addObject("imageLink", "https://static.quotery.com/backgrounds/1280/bookmarks-1280.jpg");
		modelAndView.addObject("lstCollections", lstCollections);
		modelAndView.setViewName("collections/collections");
		return modelAndView;
	}
	
	@RequestMapping(value = "/top-greatest-quotes-all-time", method = RequestMethod.GET)
	public ModelAndView TopGreatestQuotesAllTime(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/top-greatest-quotes-all-time");
		return modelAndView;
	}
	
	@RequestMapping(value = "/triumphant-veterans-day-quotes", method = RequestMethod.GET)
	public ModelAndView TriumphantVeteransDayQuotes(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/triumphant-veterans-day-quotes");
		return modelAndView;
	}
	
	@RequestMapping(value = "/outrageously-arrogant-quotes-kanye-west", method = RequestMethod.GET)
	public ModelAndView OutrageouslyArrogantQuotesKanyeWest(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/outrageously-arrogant-quotes-kanye-west");
		return modelAndView;
	}
	
	@RequestMapping(value = "/innovative-quotes-steve-jobs", method = RequestMethod.GET)
	public ModelAndView InnovativeQuotesSteveJobs(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/innovative-quotes-steve-jobs");
		return modelAndView;
	}
	
	@RequestMapping(value = "/festive-thanksgiving-quotes-celebrating-gratitude", method = RequestMethod.GET)
	public ModelAndView FestiveThanksgivingQuotesCelebratingGratitude(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;
		
		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/festive-thanksgiving-quotes-celebrating-gratitude");
		return modelAndView;
	}
	
	@RequestMapping(value = "/game-thrones-quotes", method = RequestMethod.GET)
	public ModelAndView GameThronesQuotes(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/game-thrones-quotes");
		return modelAndView;
	}
	
	@RequestMapping(value = "/political-election-day-quotes", method = RequestMethod.GET)
	public ModelAndView PoliticalElectionDayQuoes(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/political-election-day-quotes");
		return modelAndView;
	}
	
	@RequestMapping(value = "/celebratory-labor-day-quotes", method = RequestMethod.GET)
	public ModelAndView CelebratoryLaborDayQuotes(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/celebratory-labor-day-quotes");
		return modelAndView;
	}
	
	@RequestMapping(value = "/fascinating-winston-churchill-quotes", method = RequestMethod.GET)
	public ModelAndView FascinatingWinstonChurchillQuotes(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/fascinating-winston-churchill-quotes");
		return modelAndView;
	}
	
	@RequestMapping(value = "/encouraging-graduation-quotes", method = RequestMethod.GET)
	public ModelAndView EncouragingGraduationQuotes(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/encouraging-graduation-quotes");
		return modelAndView;
	}
	
	@RequestMapping(value = "/enlightening-quotes-aspiring-writers", method = RequestMethod.GET)
	public ModelAndView EnlighteningQuotesAspiringWriters(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/enlightening-quotes-aspiring-writers");
		return modelAndView;
	}
	
	@RequestMapping(value = "/uplifting-friendship-quotes", method = RequestMethod.GET)
	public ModelAndView UpliftingFriendshipQuotes(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/uplifting-friendship-quotes");
		return modelAndView;
	}
	
	@RequestMapping(value = "/patriotic-independence-day-quotes", method = RequestMethod.GET)
	public ModelAndView PatrioticIndependenceDayQuotes(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/patriotic-independence-day-quotes");
		return modelAndView;
	}
	
	@RequestMapping(value = "/motivational-fitness-quotes-get-shape", method = RequestMethod.GET)
	public ModelAndView MotivationalFitnessQuotesGetShape(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/motivational-fitness-quotes-get-shape");
		return modelAndView;
	}
	
	@RequestMapping(value = "/incredibly-profound-quotes-mister-rogers", method = RequestMethod.GET)
	public ModelAndView IncrediblyProfoundQuotesMisterRogers(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/incredibly-profound-quotes-mister-rogers");
		return modelAndView;
	}
	
	@RequestMapping(value = "/remarkable-albert-einstein-quotes", method = RequestMethod.GET)
	public ModelAndView RemarkableAlbertEinsteinQuotes(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/remarkable-albert-einstein-quotes");
		return modelAndView;
	}
	
	@RequestMapping(value = "/great-quotes-great-women", method = RequestMethod.GET)
	public ModelAndView GreatQuotesGreatWomen(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/great-quotes-great-women");
		return modelAndView;
	}
	
	@RequestMapping(value = "/empowering-startup-quotes-successful-entrepreneurs", method = RequestMethod.GET)
	public ModelAndView EmpoweringStartupQuotesSuccessfulEntrepreneurs(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/empowering-startup-quotes-successful-entrepreneurs");
		return modelAndView;
	}
	
	@RequestMapping(value = "/wickedly-wonderful-halloween-quotes", method = RequestMethod.GET)
	public ModelAndView WickedlyWonderfulHalloweenQuotes(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/wickedly-wonderful-halloween-quotes");
		return modelAndView;
	}
	
	@RequestMapping(value = "/delightful-coffee-quotes", method = RequestMethod.GET)
	public ModelAndView DelightfulCoffeeQuotes(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/delightful-coffee-quotes");
		return modelAndView;
	}
	
	@RequestMapping(value = "/invaluable-investment-quotes", method = RequestMethod.GET)
	public ModelAndView InvaluableInvestmentQuotes(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/invaluable-investment-quotes");
		return modelAndView;
	}
	
	@RequestMapping(value = "/notable-quotes-quotations-themselves", method = RequestMethod.GET)
	public ModelAndView NotableQuotesQuatationsThemselves(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/notable-quotes-quotations-themselves");
		return modelAndView;
	}
	
	@RequestMapping(value = "/top-inspirational-quotes-all-time", method = RequestMethod.GET)
	public ModelAndView TopInspirationalQuotesAllTime(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/top-inspirational-quotes-all-time");
		return modelAndView;
	}
	
	@RequestMapping(value = "/glorious-memorial-day-quotes", method = RequestMethod.GET)
	public ModelAndView GloriousMemorialDayQuotes(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/glorious-memorial-day-quotes");
		return modelAndView;
	}
	
	@RequestMapping(value = "/wonderful-mothers-day-quotes", method = RequestMethod.GET)
	public ModelAndView WonderfulMothersDayQuotes(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/wonderful-mothers-day-quotes");
		return modelAndView;
	}
	
	@RequestMapping(value = "/memorable-dr-seuss-quotes", method = RequestMethod.GET)
	public ModelAndView MemorableDrSeussQuotes(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/memorable-dr-seuss-quotes");
		return modelAndView;
	}
	
	@RequestMapping(value = "/top-funny-quotes-all-time", method = RequestMethod.GET)
	public ModelAndView TopFunnyQuotesAllTime(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/top-funny-quotes-all-time");
		return modelAndView;
	}
	
	@RequestMapping(value = "/humorous-quotes-amusement", method = RequestMethod.GET)
	public ModelAndView HumorousQuotesAmusement(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/humorous-quotes-amusement");
		return modelAndView;
	}
	
	@RequestMapping(value = "/inspiring-quotes-martin-luther-king", method = RequestMethod.GET)
	public ModelAndView InspiringQuotesMartinLutherKing(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/inspiring-quotes-martin-luther-king");
		return modelAndView;
	}
	
	@RequestMapping(value = "/top-love-quotes-all-time", method = RequestMethod.GET)
	public ModelAndView TopLoveQuotesAllTime(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/top-love-quotes-all-time");
		return modelAndView;
	}
	
	@RequestMapping(value = "/remarkable-fathers-day-quotes", method = RequestMethod.GET)
	public ModelAndView RemarkableFathersDayQuotes(ModelAndView modelAndView, HttpServletRequest request) {
		String collectionLink = request.getRequestURI().substring(1);
		int defaultPage = 1;
		int defaultPerPage = 60;

		List<Object[]> lstObj = collectionService.getCollectionNameAndImage(collectionLink);
		String nameObj = lstObj.get(0)[0].toString();
		String imageLink = lstObj.get(0)[1].toString();
		
		List<Quote> lstQuotes = quoteService.findByCollection(collectionLink, defaultPage, defaultPerPage);
		
		modelAndView.addObject("nameObj", nameObj);
		modelAndView.addObject("imageLink", imageLink);
		modelAndView.addObject("lstQuotes", lstQuotes);
		
		modelAndView.setViewName("collections/remarkable-fathers-day-quotes");
		return modelAndView;
	}
}
