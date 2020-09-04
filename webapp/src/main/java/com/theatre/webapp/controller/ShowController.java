package com.theatre.webapp.controller;

import com.theatre.webapp.domain.Show;
import com.theatre.webapp.domain.ShowGenre;
import com.theatre.webapp.domain.ShowReview;
import com.theatre.webapp.dto.ShowEditDto;
import com.theatre.webapp.dto.ShowInsertDto;

import com.theatre.webapp.dto.ShowViewDto;
import com.theatre.webapp.service.ShowService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@Log4j2
//@RequestMapping(value = "test")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {

        this.showService = showService;
    }


    @RequestMapping("/shows")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<ShowViewDto> showList = showService.getAll();
        modelAndView.addObject("showList", showList);
        modelAndView.setViewName("showList");
        return modelAndView;
    }

    @RequestMapping(value = "/shows/{id}", method = GET)
    public ModelAndView getShow(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        ShowViewDto showViewDto = showService.getShowByID(id);
        modelAndView.addObject("showList", showViewDto);
        modelAndView.setViewName("showList");
        return modelAndView;
    }


    @RequestMapping(value = "/addShow", method = GET)
    public ModelAndView redirectToAddShow() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("showInsertDto", new ShowInsertDto());
        modelAndView.setViewName("addShow");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = POST)
    public ModelAndView addShow(@ModelAttribute("showInsertDto")
                                        ShowInsertDto showInsertDto) {
        ModelAndView modelAndView = new ModelAndView();
        showService.addShow(showInsertDto);
        modelAndView.addObject("showList", showService.getAll());
        modelAndView.setViewName("showList");
        return modelAndView;
    }

    @GetMapping(value = "/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        ShowViewDto detailShow = showService.getShowByID(id);
        modelAndView.addObject("detailShow", detailShow);
        ShowReview showReview = new ShowReview();
        modelAndView.addObject("showReview", showReview);
        modelAndView.setViewName("detailShow");
        return modelAndView;
    }

    @PostMapping(value = "/detail/{id}")
    public ModelAndView addReview(@PathVariable("id")  Integer id,
                                  @ModelAttribute("showInsertDto") ShowInsertDto showInsertDto) {
        ModelAndView modelAndView = new ModelAndView();
        ShowViewDto detailShow = showService.getShowByID(id);
        showService.addReview(showInsertDto);
        modelAndView.addObject("detailShow", detailShow);
        modelAndView.setViewName("detailShow");
        return modelAndView;
    }


    @RequestMapping(value = "/edit/{id}")
    public ModelAndView redirectEditShow(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        ShowViewDto editShow = showService.getShowByID(id);
        modelAndView.addObject("editShow", editShow);
        modelAndView.setViewName("editShow");
        return modelAndView;
    }


    @RequestMapping(value = "/edit/{id}", method = POST)
    public ModelAndView editShow(@ModelAttribute("showEditDto")
                                         ShowEditDto showEditDto) {
        ModelAndView modelAndView = new ModelAndView();
        showService.editShow(showEditDto);
        modelAndView.addObject("showList", showService.getAll());
        modelAndView.setViewName("showList");
        return modelAndView;
    }
    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        showService.delete(id);
        modelAndView.addObject("showList", showService.getAll());
        modelAndView.setViewName("showList");
        return modelAndView;
    }


    //    @RequestMapping(value = "/search", method = GET)
//    public ModelAndView search(@RequestParam String keyword) {
//        ModelAndView modelAndView = new ModelAndView();
//        ShowViewDto showViewDto = showService.searchText(keyword);
//        modelAndView.addObject("result", showViewDto);
//        modelAndView.setViewName("search");
//        return modelAndView;
//    }

    @RequestMapping(value = "/search", method = GET)
    public ModelAndView search(@RequestParam Optional<String> show_name) {
        ModelAndView modelAndView = new ModelAndView();
        List<Show> show = showService.search(show_name);
        modelAndView.addObject("showList", show);
        modelAndView.setViewName("showList");
        return modelAndView;
    }
    @RequestMapping("shows/paginare")
    public ModelAndView paginare() {
        ModelAndView modelAndView = new ModelAndView();
        int currentPage = 1;
        Page<ShowViewDto> page = showService.listAll(currentPage);
        int totalItems = page.getNumber();
        int totalPages = page.getTotalPages();
        List<ShowViewDto> showList2 = page.getContent();
        modelAndView.addObject("totalItems", totalItems);
        modelAndView.addObject("totalPages", totalPages);
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("showList2", showList2);
        modelAndView.setViewName("showList");
        return modelAndView;
    }

//    @GetMapping("/page/{pageNumber}")
//    public String listByPage( Model model,
//                              @PathVariable("pageNumber") int currentPage){
//
//        Page<ShowViewDto> page = showService.listAll(currentPage);
//        int totalItems = page.getNumber();
//        int totalPages = page.getTotalPages();
//        List<ShowViewDto> showList = page.getContent();
//        model.addAttribute("totalItems", totalItems);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("currentPage", currentPage);
//        return "showList";
//    }

//    @GetMapping("/page/{i}")
//    public ModelAndView listByPage(
//            @PathVariable("i") int currentPage) {
//        ModelAndView modelAndView = new ModelAndView();
//        Page<ShowViewDto> page = showService.listAll(currentPage);
//        int totalItems = page.getNumber();
//        int totalPages = page.getTotalPages();
//        List<ShowViewDto> showList2 = page.getContent();
//        modelAndView.addObject("totalItems", totalItems);
//        modelAndView.addObject("totalPages", totalPages);
//        modelAndView.addObject("currentPage", currentPage);
//        modelAndView.addObject("showList2", showList2);
//        modelAndView.setViewName("showList");
//        return modelAndView;
//    }


}
