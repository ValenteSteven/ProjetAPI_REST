package projetapi_rest

class Book {

    String name
    Date releaseDate
    String isbn
    String author

    static belongsTo=[library:Library]

    static constraints = {
        name    blank: false
        releaseDate    nullable: false
        isbn    nullable: false
        author  blank: false
    }

    @Override
    String toString(){
        return "id : "+ id + " \n name : "+name + " \n isbn : "+isbn + " \n author : "+author
    }
}
