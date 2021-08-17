package org.danny.ex3.controller;

import lombok.extern.log4j.Log4j2;
import org.danny.ex3.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequestMapping("/sample")
@Log4j2
@Controller
public class SampleController {

    @GetMapping("/ex1")
    public String ex1() {
        log.info("ex1~~~~~~~~~");
        return "ex1";
    }

    @GetMapping({"/ex2"})
    public String exModel(Model model){
        List<SampleDTO> list = IntStream.rangeClosed(1, 20).asLongStream().mapToObj(i -> {
            SampleDTO dto = SampleDTO.builder()
                    .sno(i)
                    .firstName("First" + i)
                    .last("Last" + i)
                    .regTime(LocalDateTime.now())
                    .build();
            return dto;
        }).collect(Collectors.toList());

        model.addAttribute("list", list);
        return "ex2";
    }
}
