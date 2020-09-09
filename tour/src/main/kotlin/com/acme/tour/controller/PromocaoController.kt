package com.acme.tour.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import com.acme.tour.model.Promocao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import java.util.concurrent.ConcurrentHashMap

@RestController
class PromocaoController{

    @Autowired
    lateinit  var promocoes: ConcurrentHashMap<Long, Promocao>

    @RequestMapping(value= ["/stayHello"], method = arrayOf(RequestMethod.GET))
    fun sayHello(): String{
        return "Hello World"
    }
    @RequestMapping(value= ["/promocoes/{id}"], method = arrayOf(RequestMethod.GET))
    fun getPromocao(@PathVariable  id: Long) = promocoes[id]
}