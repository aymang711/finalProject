package GUI;


import java.util.ArrayList;
import java.util.List;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;
import org.jgap.impl.RandomFitnessFunction;

class Cargo {
    private String name;
    private int length, width, height;
    private int x, y, z;

    public Cargo(String name, int length, int width, int height, int x, int y, int z) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return length * width * height;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}

class GAForContainer {

    public static void main(String[] args) throws Exception {
        // Initialize the genetic algorithm
        Configuration gaConf = new DefaultConfiguration();
        gaConf.setPreservFittestIndividual(true);
        gaConf.setFitnessFunction(new RandomFitnessFunction());
        gaConf.setPopulationSize(100);

        // Define the chromosome
        Gene[] sampleGenes = new Gene[9];
        sampleGenes[0] = new IntegerGene(gaConf, 0, 100);
        sampleGenes[1] = new IntegerGene(gaConf, 0, 100);
        sampleGenes[2] = new IntegerGene(gaConf, 0, 100);
        sampleGenes[3] = new IntegerGene(gaConf, 0, 100);
        sampleGenes[4] = new IntegerGene(gaConf, 0, 100);
        sampleGenes[5] = new IntegerGene(gaConf, 0, 100);
        sampleGenes[6] = new IntegerGene(gaConf, 0, 100);
        sampleGenes[7] = new IntegerGene(gaConf, 0, 100);
        sampleGenes[8] = new IntegerGene(gaConf, 0, 100);
        IChromosome sampleChromosome = new Chromosome(gaConf, sampleGenes);
        gaConf.setSampleChromosome(sampleChromosome);

        // Create the initial population
        Genotype population = Genotype.randomInitialGenotype(gaConf);
        // Evolve the population
        for (int i = 0; i < 100; i++) {
            population.evolve();
        }
        // Print the best solution
        IChromosome bestSolution = population.getFittestChromosome();
        System.out.println("Best solution:");
        System.out.println("Remaining volume: " + bestSolution.getFitnessValue());

        // Extract the cargo information from the best solution
        // ...
        // Extract the cargo information from the best solution
       
        List<Cargo> sortedCargos = new ArrayList<Cargo>();
        for (int i = 0; i < 3-1; i++) {
            int volume = (Integer) bestSolution.getGene(i*3).getAllele();
            int x = (Integer) bestSolution.getGene(i*3+1).getAllele();
            int y = (Integer) bestSolution.getGene(i*3+2).getAllele();
            int z = (Integer) bestSolution.getGene(i*3+3).getAllele();
            sortedCargos.add(new Cargo("Cargo" + i, volume, volume, volume, x, y, z));
        }
        // Print the sorted cargos
        for (Cargo cargo : sortedCargos) {
            System.out.println(cargo.getName() + ": volume=" + cargo.getVolume() + " x=" + cargo.getX() + " y=" + cargo.getY() + " z=" + cargo.getZ());
        }
    

        // Print the sorted cargos
        for (Cargo cargo : sortedCargos) {
            System.out.println(cargo.getName() + ": volume=" + cargo.getVolume() + " x=" + cargo.getX() + " y=" + cargo.getY() + " z=" + cargo.getZ());
        }
    }
    // ...
}

        

