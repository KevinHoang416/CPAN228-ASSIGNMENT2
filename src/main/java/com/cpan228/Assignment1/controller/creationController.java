package com.cpan228.Assignment1.controller;

import java.util.EnumSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpan228.Assignment1.model.Item;
import com.cpan228.Assignment1.model.Item.Brand;
import com.cpan228.Assignment1.repository.ItemRepository;
// import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/creation")
public class creationController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public String creation() {
        return "creation";
    }

    @ModelAttribute
    public void brands(Model model) {
        var brands = EnumSet.allOf(Brand.class);
        model.addAttribute("brands", brands);
        log.info("brands converted", brands);
    }

    @ModelAttribute
    public Item item() {
        return Item
                .builder()
                .build();
    }

    @PostMapping
    public String processItemAddition(@Valid Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "design";
        }
        log.info("Processing item: {}", item);
        itemRepository.save(item);
        return "redirect:/itemlist";
    }
}
