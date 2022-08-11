package com.sinaukoding21.tugas6.controller;

import com.sinaukoding21.tugas6.common.Response;
import com.sinaukoding21.tugas6.model.dto.UserDTO;
import com.sinaukoding21.tugas6.model.user;
import com.sinaukoding21.tugas6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping
    public Response findAlluser() {
        return new Response(
                service.findAlluser(),
                service.findAlluser().size(),
                HttpStatus.OK);
    }

    @PostMapping
    public Response saveuser(@RequestBody UserDTO param) {
        return new Response(
                service.createuser(param),
                "Data Berhasil Disimpan!",
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Response deleteuser(@PathVariable Integer id) {
        if (service.deleteuser(id)){
            return new Response("Berhasil dihapus", HttpStatus.OK);
        }

        return new Response("Gagal dihapus", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateuser(@PathVariable Integer id,
                                        @RequestBody user user) {
        return new ResponseEntity(service.updateuser(id, user), HttpStatus.OK);
    }

    @GetMapping("/find-by-id/{id}")
    public Response getById(@PathVariable Integer id){
        return new Response(service.findById(id), "Data ditemukan", HttpStatus.OK);
    }
}