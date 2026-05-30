package edu.citytech.counter.services;

import java.util.ArrayList;
import java.util.List;

import edu.citytech.counter.dto.REITS;
import edu.citytech.counter.utility.DBUtility;
import jakarta.inject.Singleton;

import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Projections.include;
import static com.mongodb.client.model.Sorts.descending;

@Singleton
public class REITSService {
    final static String databaseName = "stocks";
    final static String collection = "reits";
    final Bson projection = include("rank", "symbol", "marketCapInBillions");
    final Bson find = new Document();
    final Bson sort = descending("symbol");

    public List<REITS> findAll() {
        List<REITS> list = new ArrayList<>();

        DBUtility.query(REITS.class, list::add, databaseName, collection, projection, find, sort);

        return list;
    }
}