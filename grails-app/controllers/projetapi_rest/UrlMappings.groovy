package projetapi_rest

class UrlMappings {

    static mappings = {
        "/library/$libraryID"(controller:'RequestManager',action:'showLibrary',method:'GET')
        "/libraries"(controller:'RequestManager',action:'showLibraries',method:'GET')
        "/book/$bookID"(controller:'RequestManager',action:'showBook',method:'GET')
        "/books"(controller:'RequestManager',action:'showBooks',method:'GET')
        "/library/$libraryID/book/$bookID"(controller:'RequestManager',action:'showBookByLibrary',method:'GET')
        "/library/$libraryID/books"(controller:'RequestManager',action:'showBooksByLibrary',method:'GET')
        "/book/$id"(controller:'RequestManager',action:'deleteBook',method:'DELETE')
        "/library/$id"(controller:'RequestManager',action:'deleteLibrary',method:'DELETE')
        "/book/$id"(controller:'RequestManager',action:'updateBook',method:'PUT')
        "/library/$id"(controller:'RequestManager',action:'updateLibrary',method:'PUT')
        "/library"(controller:'RequestManager',action:'createLibrary',method:'POST')
        "/book"(controller:'RequestManager',action:'createBook',method:'POST')


        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
        }

    }
