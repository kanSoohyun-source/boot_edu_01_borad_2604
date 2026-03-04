package boot_edu_01_board_2603.controller;

import boot_edu_01_board_2603.dto.BoardDTO;
import boot_edu_01_board_2603.dto.PageRequestDTO;
import boot_edu_01_board_2603.dto.PageResponseDTO;
import boot_edu_01_board_2603.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        log.info("list get...");

        PageResponseDTO<BoardDTO> pageResponseDTO = boardService.getList(pageRequestDTO);
        log.info("pageResponseDTO: {}", pageResponseDTO);

        model.addAttribute("pageResponseDTO", pageResponseDTO);
    }
}