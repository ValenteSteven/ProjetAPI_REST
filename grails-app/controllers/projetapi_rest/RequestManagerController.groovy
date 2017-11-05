package projetapi_rest

import grails.converters.JSON

class RequestManagerController {

    //Obtenir un livre
    def showBook() {
        String stringBookId = String.valueOf(params.get("bookID"))
        long bookId =  Long.parseLong(stringBookId)

        if(Book.findById(bookId)) {
            def L = Book.get(bookId)
            render L as JSON
        }
        else {
            render (status: 404,text: "le livre ${params.bookID} n'existe pas ! " )
        }
    }

    //Obtenir tout les livres
    def showBooks(){

        if(Book.all.size() != 0){
            render Book.all as JSON
        }

        else {
            render (status: 404,text: "il n'y a aucun livre")
        }
    }

    // obtenir toutes les bibliotheques
    def showLibraries(){
        if(Library.all.size() != 0){
            render Library.all as JSON
        }

        else {
            render (status: 404,text: "il n'y a aucune bibliotheque")
        }
    }

    // obtenir une bibliotheque
    def showLibrary() {
        String stringLibraryId = String.valueOf(params.get("libraryID"))
        Long libraryId = Long.parseLong(stringLibraryId)
            if(Library.findById(libraryId)) {
                def L = Library.get(libraryId)
                render L as JSON
            }
            else {
                render (status: 404,text: "la bibliotheque ${params.libraryID} n'existe pas ! " )
            }
    }

    // mise a jour d'un livre
    def updateBook(Book b){
        if( b != null){
            b.save(flush:true)
            render (status: 200,text: "livre mis a jour" )
        }

        else {
            render (status: 404,text: "le livre n'existe pas" )
        }
    }

    //mise a jour d'une bibliothque
    def updateLibrary(Library l){
        if( l != null){
            l.save(flush:true)
            render (status: 200,text: "bibliotheque mis a jour" )
        }

        else {
            render (status: 404,text: "la bibliotheque n'existe pas" )
        }
    }


    // supression d'une bibliotheque
    def deleteLibrary(Library l) {
        if( l != null){
            l.delete(flush:true)
            render (status: 200,text: "OK" )
        }
        else {
            render (status: 404,text: "la bibliotheque n'existe pas" )
        }
    }

    // supression d'un livre
    def deleteBook(Book b){
        if( b != null){
            b.delete(flush:true)
            render (status: 200,text: "OK" )
        }
        else {
            render (status: 404,text: "le livre n'existe pas" )
        }
    }

    // creation d'une bibliotheque
    def createLibrary(Library l){

        Library newLibrary = l.save(flush:true)

        if (newLibrary != null){
            render (status: 200,text: "OK" )
        }
        else {
            render (status: 404,text: "la bibliothèque devant etre ajouté n'est pas valide" )
        }
    }

    // creation d'un livre
    def createBook(Book b){
        Book newBook = b.save(flush:true)

        if (newBook != null){
            render (status: 200,text: "OK" )
        }
        else {
            render (status: 404,text: "le livre devant etre ajouté n'est pas valide" )
        }
    }

    // obtenir un livre d'une librairie
    def showBookByLibrary() {
        String stringLibraryId = String.valueOf(params.get("libraryID"))
        Long libraryId = Long.parseLong(stringLibraryId)
        String stringBookId = String.valueOf(params.get("bookID"))
        long bookId =  Long.parseLong(stringBookId)
        Library libraryToCheck = Library.findById(libraryId)
        if (libraryToCheck != null) {

            for (Book book : libraryToCheck.getBooks()) {
                if (bookId == book.id){
                    render book as JSON
                    break
                }
            }
            render (status: 404,text: "le livre n'est pas présent dans cette bibliothèque" )
        }
        else {
            render (status: 404,text: "la bibliotheque n'existe pas" )
        }
    }

    //obtenir tout les livres d'une bibliotheque
    def showBooksByLibrary() {
        String stringLibraryId = String.valueOf(params.get("libraryID"))
        Long libraryId = Long.parseLong(stringLibraryId)
        Library libraryToCheck = Library.findById(libraryId)
        if (libraryToCheck != null) {
            if(libraryToCheck.getBooks().size() > 0){
                render libraryToCheck.getBooks() as JSON
            }
            else {
                render (status: 404,text: "aucun livre présent dans cette bibliothèque" )
            }

        }
        else {
            render (status: 404,text: "la bibliotheque n'existe pas" )
        }

    }

    def updateBookByLibrary(Book b) {
        String stringLibraryId = String.valueOf(params.get("libraryID"))
        Long libraryId = Long.parseLong(stringLibraryId)
        String stringBookId = String.valueOf(params.get("id"))
        long bookId =  Long.parseLong(stringBookId)
        Library libraryToCheck = Library.findById(libraryId)
        if (libraryToCheck != null) {
                if (libraryToCheck.books.contains(Book.findById(bookId))){
                    libraryToCheck.addToBooks(b).save(flush:true)
                    b.save(flush:true)
                    render (status: 200,text: "OK" )
                }
            else {
                    render (status: 404,text: "le livre n'est pas présent dans cette bibliothèque" )
                }
        }
        else {
            render (status: 404,text: "la bibliotheque n'existe pas" )
        }
    }

    def deleteBookByLibrary() {
        String stringLibraryId = String.valueOf(params.get("libraryID"))
        Long libraryId = Long.parseLong(stringLibraryId)
        String stringBookId = String.valueOf(params.get("id"))
        long bookId =  Long.parseLong(stringBookId)
        Library libraryToCheck = Library.findById(libraryId)
        if (libraryToCheck != null) {
            if (libraryToCheck.books.contains(Book.findById(bookId))){
                Book bookToDelete = Book.findById(bookId)
                libraryToCheck.removeFromBooks(bookToDelete)
                libraryToCheck.save(flush:true)
                bookToDelete.delete(flush:true)

                render (status: 200,text: "OK" )
            }
            else {
                render (status: 404,text: "le livre n'est pas présent dans cette bibliothèque" )
            }
        }
        else {
            render (status: 404,text: "la bibliotheque n'existe pas" )
        }
    }

    def createBookByLibrary(Book b) {
        String stringLibraryId = String.valueOf(params.get("libraryID"))
        Long libraryId = Long.parseLong(stringLibraryId)
        Library libraryToCheck = Library.findById(libraryId)
        if (libraryToCheck != null) {
            if (b != null) {

                libraryToCheck.addToBooks(b).save(flush: true)
                b.save(flush:true)
                render(status: 200, text: "OK")
            }

            else {
                render(status: 404, text: "le livre est invalide")
            }

        }

        else {
            render (status: 404,text: "la bibliotheque n'existe pas" )
        }
    }


}

