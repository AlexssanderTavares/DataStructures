import org.jetbrains.annotations.NotNull;

public class Document implements Comparable<Document>{

    private String name;
    private int pages;

    public Document(){
    }

    public Document(String name, int pages){
       // super();
        this.setName(name);
        this.setPages(pages);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPages(int numPages){
        this.pages = numPages;
    }

    public String getName(){
        return this.name;
    }

    public int pages(){
        return this.pages;
    }

    @Override
    public int compareTo(@NotNull Document o) {
        if(this.pages < o.pages){
            return 1;
        } else if(this.pages == o.pages){
            return 0;
        } else {
            return -1;
        }
    }

}
