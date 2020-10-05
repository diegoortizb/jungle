package com.java.jungle.controllers;

import com.java.jungle.model.voteExample;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/home")
public class HomeController {
    private List<voteExample> voters = new ArrayList<>();
    private AtomicLong nextId = new AtomicLong();

    @GetMapping("/home")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @PostMapping("/vote")
    public voteExample createNewVoter(@RequestBody voteExample voter) {
        //set voter to have next ID
        voter.setId(nextId.incrementAndGet());
        voters.add(voter);
        return voter;
    }
}
