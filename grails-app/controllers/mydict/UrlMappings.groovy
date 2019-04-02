package mydict

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/login" (view:"/login")
        "/doLogin" (controller:'me',action: 'doLogin')
        "/"(redirect: '/word/index')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
