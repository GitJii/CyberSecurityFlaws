package sec.project.controller;
 
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sec.project.domain.GifObject;
import sec.project.repository.GifObjectRepository;
 
@Controller
public class GifController {
 
    @Autowired
    private GifObjectRepository gifRepository;
 
    @GetMapping("/gifs")
    public String view() {
        return "redirect:/gifs/1";
    }
 
    @GetMapping(value = "/gifs/{id}")
    public String viewOne(Model model, @PathVariable Long id) {
        Long imageCount = gifRepository.count();
        model.addAttribute("count", imageCount);
 
        if (id >= 1L && id <= imageCount) {
            model.addAttribute("current", id);
        }
 
        if (id < imageCount && id > 0L) {
            model.addAttribute("next", id + 1);
        }
 
        if (id > 1L) {
            model.addAttribute("previous", id - 1);
        }
 
        return "gifs";
    }
 
    @PostMapping("/gifs")
    public String add(@RequestParam("file") MultipartFile file) throws IOException {
//        if (!file.getContentType().equals("image/gif")) {
//            return "redirect:/gifs";
//        }
 
        GifObject gifObject = new GifObject();
        gifObject.setContent(file.getBytes());
        gifRepository.save(gifObject);
 
        return "redirect:/gifs";
    }
 
    @GetMapping(path = "/gifs/{id}/content", produces = "image/gif")
    @ResponseBody
    public byte[] getContent(@PathVariable Long id) {
        return gifRepository.getOne(id).getContent();
    }
}
