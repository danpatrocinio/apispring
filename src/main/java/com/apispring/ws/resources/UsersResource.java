package com.apispring.ws.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apispring.model.Users;
import com.apispring.model.repositories.UsersRepository;

@RestController
@RequestMapping("/users")
public class UsersResource {

	@Autowired
	UsersRepository userRep;

	@RequestMapping(value = "atualizar", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> atualizar(@RequestBody Users u) {

		if (u == null) {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
		Users userAtualizado = userRep.save(u);
		return new ResponseEntity<Users>(userAtualizado, HttpStatus.OK);
	}

	@RequestMapping(value = "deletar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Users> deletar(@PathVariable String id) {

		if (id == null || id.length() <= 0) {
			return new ResponseEntity<Users>(HttpStatus.BAD_REQUEST);
		}
		Users userDel = userRep.findOne(id);
		if (userDel == null) {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
		userRep.delete(userDel);
		return new ResponseEntity<Users>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> getById(@PathVariable String id) {

		return new ResponseEntity<Users>(userRep.findOne(id), HttpStatus.OK);
	}

	@RequestMapping(value = "listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Users>> listar() {

		return new ResponseEntity<List<Users>>(userRep.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> salvar(@RequestBody Users u) {

		Users userSaved = null;
		if (u != null) {
			userSaved = userRep.save(u);
		}

		return new ResponseEntity<Users>(userSaved, HttpStatus.CREATED);
	}
}
