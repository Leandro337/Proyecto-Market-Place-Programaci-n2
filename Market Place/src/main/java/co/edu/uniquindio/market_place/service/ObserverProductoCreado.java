package co.edu.uniquindio.market_place.service;

import co.edu.uniquindio.market_place.model.Producto;

public interface ObserverProductoCreado {
    void onProductoCreado(Producto producto);
}
