package com.springboot.test.data.repository;

import com.springboot.test.data.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @DataJpaTest
 * JPA와 관련된 설정만 로드해서 테스트를 진행
 * @Transactinal 어노테이션을 기본적으로 포함하고 있어 테스트코드가 종료되면 자동으로 데이베이스를 롤백 해줌 ㅅㄱ
 * 기본값으로 임베디드 데이터베이스를 사용함 (디른 데이터베이스를 사용하려면 별도 설정 필요)
 */
@DataJpaTest
class ProductRepositoryTestByH2 {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveTest(){

        //given
        Product product = new Product();
        product.setName("펜");
        product.setPrice(1000);
        product.setStock(1000);

        //when
        Product saveProduct = productRepository.save(product);

        //then
        assertEquals(product.getName(), saveProduct.getName());
        assertEquals(product.getPrice(), saveProduct.getPrice());
        assertEquals(product.getStock(), saveProduct.getStock());

    }

    @Test
    void selectTest(){

        //given
        Product product = new Product();
        product.setName("펜");
        product.setPrice(1000);
        product.setStock(1000);

        Product savedProduct = productRepository.saveAndFlush(product);

        //when
        Product foundProduct = productRepository.findById(savedProduct.getNumber()).get();

        //then
        assertEquals(product.getName(), foundProduct.getName());
        assertEquals(product.getPrice(), foundProduct.getPrice());
        assertEquals(product.getStock(), foundProduct.getStock());


    }

}








