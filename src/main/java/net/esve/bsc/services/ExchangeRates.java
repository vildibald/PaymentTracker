package net.esve.bsc.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ExchangeRates implements ConcurrentMap<String, Double> {

    private static Double rate;
    private final ConcurrentMap<String, Double> exchangeRates = new ConcurrentHashMap<String, Double>() {
        private static final long serialVersionUID = 5850880745871856632L;

        {
            put("EUR", 1.27);
            put("CZK", 28.05);
            put("HUF", 350.00);
        }
    };

    private ExchangeRates() {
    }

    public static ExchangeRates getInstance() {
        return Holder.INSTANCE;
    }

    public BigDecimal getRate(Entry<String, BigDecimal> entry) {
        BigDecimal amount = BigDecimal.ZERO;
        rate = exchangeRates.get(entry.getKey());
        if (rate != null) {
            amount = entry.getValue().multiply(new BigDecimal(rate)).setScale(2, RoundingMode.HALF_UP);
        }
        return amount;
    }

    @Override
    public int size() {
        return exchangeRates.size();
    }

    @Override
    public boolean isEmpty() {
        return exchangeRates.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return exchangeRates.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return exchangeRates.containsValue(value);
    }

    @Override
    public Double get(Object key) {
        return exchangeRates.get(key);
    }

    @Override
    public Double put(String key, Double value) {
        return exchangeRates.put(key, value);
    }

    @Override
    public Double remove(Object key) {
        return exchangeRates.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends Double> m) {
        exchangeRates.putAll(m);
    }

    @Override
    public void clear() {
        exchangeRates.clear();
    }

    @Override
    public Set<String> keySet() {
        return exchangeRates.keySet();
    }

    @Override
    public Collection<Double> values() {
        return exchangeRates.values();
    }

    @Override
    public Set<Entry<String, Double>> entrySet() {
        return exchangeRates.entrySet();
    }

    @Override
    public Double putIfAbsent(String key, Double value) {
        return exchangeRates.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return exchangeRates.remove(key, value);
    }

    @Override
    public boolean replace(String key, Double oldValue, Double newValue) {
        return exchangeRates.replace(key, oldValue, newValue);
    }

    @Override
    public Double replace(String key, Double value) {
        return exchangeRates.replace(key, value);
    }

    private static class Holder {
        static final ExchangeRates INSTANCE = new ExchangeRates();
    }
}
