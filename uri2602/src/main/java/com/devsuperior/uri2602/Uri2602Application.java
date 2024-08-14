package com.devsuperior.uri2602;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.repositories.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

	@Autowired
	private CustomRepository customRepository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<CustomerMinProjection> list = customRepository.search1("RS");

		List<CustomerMinDTO> result1 = list.stream().map(
				//transformando cada elemento da lista acima em um DTO
				x -> new CustomerMinDTO(x)
		).collect(Collectors.toList());

		System.out.println("RESULTADO PRIMEIRA CONSULTA");
		for (CustomerMinDTO obj : result1) {
			System.out.println(obj);
		}
		System.out.println();

		System.out.println("RESULTADO SEGUNDA CONSULTA");

		List<CustomerMinDTO> result2 = customRepository.search2("rs");
		for (CustomerMinDTO obj : result2) {
			System.out.println(obj);
		}

	}
}
