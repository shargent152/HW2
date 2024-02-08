package c322spring2024homework2.Guitar.Controllers;


import c322spring2024homework2.Guitar.repository.Invertory;
import c322spring2024homework2.Guitar.Model.Guitar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guitar")
public class GuitarWeb {
    private Invertory guitar;
    @Autowired
    public GuitarWeb(Invertory guitar) {
        this.guitar = guitar;
    }
    @PostMapping
    public boolean add(@RequestBody Guitar data){
        try {
            return guitar.addGuitar(data);
        } catch (IOException e) {
            return false;
        }
    }
    @GetMapping("/search")
    public List<Guitar> search(@RequestParam(defaultValue = "") String serialNumber,
                               @RequestParam (defaultValue = "") String price,
                               @RequestParam (defaultValue = "") String builder,
                               @RequestParam (defaultValue = "") String model,
                               @RequestParam (defaultValue = "") String type,
                               @RequestParam (defaultValue = "") String backWood,
                               @RequestParam (defaultValue = "") String topWood){
        Guitar get = new Guitar();
        get.setTopWood(topWood);
        get.setBackWood(backWood);
        get.setBuilder(builder);
        get.setType(type);
        get.setSerialNumber(serialNumber);
        get.setPrice(Double.parseDouble(price));
        get.setModel(model);
        try {
            return guitar.searchGuitar(get);
        }catch (IOException e){
            return null;
        }
    }
    @GetMapping("/find/{serialNumber}")
    public Guitar find(@PathVariable long serialNumber){
        try {
            return guitar.getGuitar(Long.toString(serialNumber));
        }catch (IOException e){
            return null;
        }
    }

}