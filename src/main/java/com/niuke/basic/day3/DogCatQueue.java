package com.niuke.basic.day3;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue(){
        this.dogQ = new LinkedList<>();
        this.catQ = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet){
        if ("dog".equals(pet.getType())){
            this.dogQ.add(new PetEnterQueue(pet,count++));
        }else if ("cat".equals(pet.getType())){
            this.catQ.add(new PetEnterQueue(pet,count++));
        }else {
            throw new RuntimeException("err, not dog or cat");
        }
    }

    public Pet pollAll(){
        if (!dogQ.isEmpty()&&!catQ.isEmpty()){
            if (this.dogQ.peek().getCount()<this.catQ.peek().getCount()){
                return this.dogQ.poll().getPet();
            }else {
                return this.catQ.poll().getPet();
            }
        }else if (!dogQ.isEmpty()){
            return this.dogQ.poll().getPet();
        }else if (!catQ.isEmpty()){
            return this.catQ.poll().getPet();
        }else {
            throw new RuntimeException("queue is empty");
        }
    }

    public Pet pollDog(){
        if (!this.isDogQueueEmpty()) {
            return this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("Dog queue is empty!");
        }
    }

    public Pet pollCat(){
        if (!this.isCatQueueEmpty()) {
            return this.catQ.poll().getPet();
        } else
            throw new RuntimeException("Cat queue is empty!");
    }

    public boolean isEmpty(){
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }

    public boolean isDogQueueEmpty(){
        return dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty(){
        return catQ.isEmpty();
    }

    class Pet{
        private String type;

        public Pet(String type){
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    class Dog extends Pet{

        public Dog() {
            super("dog");
        }
    }

    class Cat extends Pet{

        public Cat() {
            super("cat");
        }
    }

    class PetEnterQueue{
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet,long count){
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }

        public String getEnterPetType(){
            return this.pet.getType();
        }
    }




}
