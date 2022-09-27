package tokosinaukoding.controller;

import tokosinaukoding.tokosinaukoding.entity.dto.ProdukDTO;
import tokosinaukoding.tokosinaukoding.service.impl.ProdukServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produk")
public class ProdukController {
    @Autowired
    private ProdukServiceImpl service;

    @GetMapping("/find-all")
    public ResponseEntity<?> findAllData(){
        return new ResponseEntity<>(service.findAllData(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveData(@RequestBody ProdukDTO param){
        return new ResponseEntity<>(service.save(param), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateData(@PathVariable Long id,
                                        @RequestBody ProdukDTO param){
        ProdukDTO data = service.update(param, id);

        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<?> findById2(@RequestParam(name = "id") Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteData(@PathVariable Long id){
        if (service.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }


    }
}