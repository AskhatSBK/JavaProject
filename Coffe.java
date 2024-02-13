import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Library library1 = new Library("MArtinIden");
        Library library2 = new Library("Shekspir");

        System.out.println(library1);
    }
}
class Library {
    private String name;
    private ArrayList<Department> departments;

    public Library(String newName) {
        name = newName;
        departments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department dep) {
        departments.add(dep);
    }

    public void removeDepartment(Department dep) {
        departments.remove(dep);
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", departments=" + departments +
                '}';
    }
}

class Department {
    private String genreName;
    private Library library;
    private ArrayList<Edition> editions;

    public void setGenreName(String genre) {
        genreName = genre;
    }

    public String getGenreName() {
        return genreName;
    }

    public int getNumberOfEditions() {
        return editions.size();
    }

    public void setLibrary(Library lib) {
        library = lib;
    }

    public Library getLibrary() {
        return library;
    }

    public ArrayList<Edition> getEditions() {
        return editions;
    }

    public void addEdition(Edition edition) {
        editions.add(edition);
    }

    public void removeEdition(Edition edition) {
        editions.remove(edition);
    }
}

class Edition {
    private String name;
    private String author;
    private Integer yearPub;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setYearPub(Integer yearPub) {
        this.yearPub = yearPub;
    }

    public Integer getYearPub() {
        return yearPub;
    }
}
