package controllers;

import business.Editor;
import business.EditorRepository;
        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping(EditorController.EDITOR_ENDPOINT)
public class EditorController extends JdbcDaoSupport {
    protected static final String EDITOR_ENDPOINT="api/editor";

    @Autowired
    EditorRepository editorRepository;

    @GetMapping("/{id]")
    Iterable<Editor> getEditors(){
        return this.editorRepository.findAll();
    }

    @GetMapping("/search-by-id")
    Editor getEditorsById(@PathVariable Long id){
        return this.editorRepository.findOne(id);
    }

    @PostMapping("/create-editor")
    public Editor createEditor(@Valid @RequestBody Editor editorToCreate) {
     return  editorRepository.save(editorToCreate);
    }
}

