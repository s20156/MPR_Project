package pjatk.project.beercalc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class RecipeBook {
    @Id
    @GeneratedValue
    private Long id;
    private List<Recipe> list;

    public RecipeBook(Long id, List<Recipe> list) {
        this.id = id;
        this.list = list;
    }

    public RecipeBook(List<Recipe> list) {
        this.list = list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Recipe> getList() {
        return list;
    }

    public void setList(List<Recipe> list) {
        this.list = list;
    }
}
