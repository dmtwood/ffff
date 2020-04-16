package be.vdab.frida.controllers;

import be.vdab.frida.services.SausService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("sauzen")
class SausController {
    private final char[] alfabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private final SausService sausService;

    SausController(SausService sausService) {
        this.sausService = sausService;
    }

    @GetMapping
    public ModelAndView sauzen() {
        return new ModelAndView("sauzen", "sauzen", sausService.findAll());
    }

    @GetMapping("{id}")
    public ModelAndView saus(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("saus");
        sausService.findById(id).ifPresent(saus -> modelAndView.addObject(saus));
        return modelAndView;
    }

    @GetMapping("alfabet")
    public ModelAndView alfabet() {
        return new ModelAndView("sausAlfabet", "alfabet", alfabet);
    }

    @GetMapping("alfabet/{letter}")
    public ModelAndView sauzenBeginnendMet(@PathVariable char letter) {
        return new ModelAndView("sausAlfabet", "alfabet", alfabet)
                .addObject("sauzen", sausService.findByNaamBegintMet(letter));
    }
}

//@Controller
//@RequestMapping("sauzen")
//class SausController {
//    private final Saus[] sauzen = {
//            new Saus(3L, "cocktail", new String[]{"mayonaise", "ketchup", "cognac"}),
//            new Saus(6L, "mayonaise", new String[]{"ei", "mosterd"}),
//            new Saus(7L, "mosterd", new String[]{"mosterdzaad", "azijn", "witte wijn"}),
//            new Saus(12L, "tartare", new String[]{"mayonaise", "augurk", "tabasco"}),
//            new Saus(44L, "vinaigrette", new String[]{"olijfolie", "mosterd", "azijn"})};
//
//    @GetMapping
//    public ModelAndView sauzen() {
//        return new ModelAndView("sauzen", "sauzen", sauzen);
//    }
//
//
//    @GetMapping("{id}")
//    public ModelAndView saus(@PathVariable long id) {
//        ModelAndView modelAndView = new ModelAndView("saus");
//        Arrays.stream(sauzen).filter(saus -> saus.getId() == id).findFirst()
//                .ifPresent(modelAndView::addObject);
//        return modelAndView;
//    }
//
//// ******************
//    private final char[] alfabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
//
//    @GetMapping("alfabet")
//    public ModelAndView alfabet() {
//        return new ModelAndView("sausAlfabet", "alfabet", alfabet);
//    }
//
//    private List<Saus> sauzenDieBeginnenMet(char letter) {
//        return Arrays.stream(sauzen).filter(saus->saus.getNaam().charAt(0)==letter)
//                .collect(Collectors.toList());
//    }
//
//    @GetMapping("alfabet/{letter}")
//    public ModelAndView sauzenBeginnendMet(@PathVariable char letter) {
//        return new ModelAndView("sausAlfabet", "alfabet", alfabet)
//                .addObject("sauzen", sauzenDieBeginnenMet(letter));
//    }
//
//
//// **********************************
//
//
//
//}