package projetapi_rest

class Library {

    String name
    String adress
    Integer yearCreated

    static hasMany = [books:Book]


    static constraints = {
        name    blank: false
        adress  blank: false
        yearCreated nullable: false
    }

    @Override
    String toString(){
        return "id : "+ id + " \n name : "+name + " \n adress : "+adress + " \n yearCreated : "+yearCreated
    }
}
