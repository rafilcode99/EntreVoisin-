package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();



    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    private List<Neighbour> mFavoriteList = new ArrayList<>();

    public List<Neighbour> getFavoriteNeighboursList(){
        return mFavoriteList;
    }


    public void addToNeighbourFavoriteList(int id){
        int i = 0;

        while ( i< neighbours.size() && id != neighbours.get(i).getId()){
            i++;
        }

        mFavoriteList.add(neighbours.get(i));


    }



}
