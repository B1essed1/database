package org.example.service;

import org.example.domain.alpha.Alpha2Entity;
import org.example.domain.alpha.AlphaEntity;
import org.example.domain.beta.BetaEntity;
import org.example.repository.alpha.Alpha2Repo;
import org.example.repository.alpha.AlphaRepo;
import org.example.repository.beta.BetaRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;


@Service
public class TestService {
    private final AlphaRepo alphaRepo;
    private final Alpha2Repo alpha2Repo;
    private final BetaRepo betaRepo;

    public TestService(AlphaRepo alphaRepo, Alpha2Repo alpha2Repo, BetaRepo betaRepo) {
        this.alphaRepo = alphaRepo;
        this.alpha2Repo = alpha2Repo;
        this.betaRepo = betaRepo;
    }


    @Transactional(value = "chainedTransactionManager")
    public String test() {
        try {
            AlphaEntity alpha = new AlphaEntity("data", 1);
            alphaRepo.save(alpha);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            BetaEntity beta = new BetaEntity("data", 1);
            betaRepo.save(beta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Success");
        return "Success";
    }


    @Transactional
    public String test2() {

        try {
            AlphaEntity alpha = new AlphaEntity("data", 1);
            alphaRepo.save(alpha);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Alpha2Entity alpha2 = new Alpha2Entity("data", 1);
            alpha2Repo.save(alpha2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Success");
        return "Success";
    }

    @Transactional("tb")
    public void fuck() {
       // gamma();
        Random random = new Random();
        Alpha2Entity alpha = new Alpha2Entity("NIXAO", random.nextInt(30));
        BetaEntity beta = new BetaEntity("BLAA", random.nextInt(25));
        try {
            betaRepo.save(beta);

        }catch (Exception e){
            System.out.println("BBBBBBBBBB");
        }
        try {
            alpha2Repo.save(alpha);
        } catch (Exception e){
            System.out.println("AAAAAAAAA");
        }



    }


    private void gamma() {
        Random random = new Random();
        Alpha2Entity alpha = new Alpha2Entity("F*ckU", random.nextInt(30));
        BetaEntity beta = new BetaEntity("ONICHAN", random.nextInt(25));
        try {
            // alpha2Repo.save(alpha);
            betaRepo.save(beta);
        } catch (Exception e) {
        }


    }


}
