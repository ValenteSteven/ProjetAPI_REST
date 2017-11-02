package projetapi_rest

class BootStrap {

    def init = { servletContext ->
        def lib1 = new Library(name: "librairie1",adress: "adress1",yearCreated: 1991)
        lib1.addToBooks(new Book(name: "book1",author: "author1",isbn: "isbn1",releaseDate: new Date()))
        lib1.addToBooks(new Book(name: "book2",author: "author2",isbn: "isbn2",releaseDate: new Date()))

        def lib12 = new Library(name: "librairie2",adress: "adress2",yearCreated: 1992)
        lib12.addToBooks(new Book(name: "name3",author: "author3",isbn: "isbn3",releaseDate: new Date()))
        lib12.addToBooks(new Book(name: "name4",author: "author4",isbn: "isbn4",releaseDate: new Date()))

        def lib13 = new Library(name: "librairie3",adress: "adress3",yearCreated: 1992)
        lib1.save(flush:true)
        lib12.save(flush:true)
        lib13.save(flush:true)
    }
    def destroy = {
    }
}
