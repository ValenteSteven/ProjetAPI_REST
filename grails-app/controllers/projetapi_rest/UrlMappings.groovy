package projetapi_rest

class UrlMappings {

    static mappings = {
        "/library/$libraryID"(controller:'test',action:'showLibrary',method:'GET')
        "/libraries"(controller:'test',action:'showLibraries',method:'GET')
        "/book/$bookID"(controller:'test',action:'showBook',method:'GET')
        "/books"(controller:'test',action:'showBooks',method:'GET')
        "/library/$libraryID/book/$bookID"(controller:'test',action:'showBookByLibrary',method:'GET')
        "/library/$libraryID/books"(controller:'test',action:'showBooksByLibrary',method:'GET')
        "/book/$id"(controller:'test',action:'deleteBook',method:'DELETE')
        "/library/$id"(controller:'test',action:'deleteLibrary',method:'DELETE')
        "/book/$id"(controller:'test',action:'updateBook',method:'PUT')
        "/library/$id"(controller:'test',action:'updateLibrary',method:'PUT')
        "/library"(controller:'test',action:'createLibrary',method:'POST')
        "/book"(controller:'test',action:'createBook',method:'POST')


        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
        }

    }
