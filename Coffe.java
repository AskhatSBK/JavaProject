import java.util.ArrayList;
import java.util.List;

class Edition {
    private String name;
    private String author;
    private int yearOfPublication;

    public Edition(String name, String author, int yearOfPublication) {
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
}

class Department {
    private String name;
    private List<Edition> publications;

    public Department(String name) {
        this.name = name;
        this.publications = new ArrayList<>();
    }

    public void addPublication(Edition publication) {
        publications.add(publication);
    }

    public void removePublication(Edition publication) {
        publications.remove(publication);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edition> getPublications() {
        return publications;
    }

    public void setPublications(List<Edition> publications) {
        this.publications = publications;
    }
}

class Library {
    private String name;
    private List<Department> departments;

    public Library(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    public List<Edition> findPublicationsByYear(int year) {
        List<Edition> foundPublications = new ArrayList<>();
        for (Department department : departments) {
            for (Edition publication : department.getPublications()) {
                if (publication.getYearOfPublication() == year) {
                    foundPublications.add(publication);
                }
            }
        }
        return foundPublications;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}

class Main {
    public static void main(String[] args) {
        Library library = new Library("Main Library");

        Department department1 = new Department("Fiction");
        Department department2 = new Department("Non-Fiction");

        Edition publication1 = new Edition("The Great Gatsby", "Scott Fitzgerald", 1925);
        Edition publication2 = new Edition("To Kill a Mockingbird", "Harper Lee", 1960);
        Edition publication3 = new Edition("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", 2011);

        library.addDepartment(department1);
        library.addDepartment(department2);

            System.out.println();
        }

        library.removeDepartment(department2);

        System.out.println("After removing department2:");
        for (Department department : library.getDepartments()) {
            System.out.println("Department: " + department.getName());
            System.out.println("Number of publications: " + department.getPublications().size());
            System.out.println();
        }

        int searchYear = 1925;
        List<Edition> foundPublications = library.findPublicationsByYear(searchYear);
        System.out.println("Publications released in " + searchYear + ":");
        for (Edition publication : foundPublications) {
            for (Department department : library.getDepartments()) {
                if (department.getPublications().contains(publication)) {
                    System.out.println(publication.getName() + " - Department: " + department.getName());
                }
            }
        }
    }
}
