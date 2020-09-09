package com.acme.tour.controller

import com.acme.tour.model.Promocao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
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

    @RequestMapping(value = ["/promocoes"], method = arrayOf(RequestMethod.POST))
    fun create(@RequestBody promocao: Promocao){
        promocoes[promocao.id] = promocao
    }

    @RequestMapping(value = ["/promocoes/{id}"], method = arrayOf(RequestMethod.DELETE))
    fun delete(@PathVariable id: Long){
        promocoes.remove(id)
    }
}