package org.example;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class
Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("en marcha Alberto");

        try {
           // Persistir una nueva entidad Person
            entityManager.getTransaction().begin();
/*
            Domicilio domicilio1 = Domicilio.builder()
                    .nombreCalle("Adolfocalle")
                    .numero(1785)
                    .build();
            Cliente cliente1 = Cliente.builder()
                    .apellido("Rodrigez")
                    .nombre("Olivia")
                    .dni(45586662)
                    .build();
            cliente1.setDomicilio(domicilio1);
            domicilio1.setCliente(cliente1);
            Categoria perecederos = Categoria.builder()
                    .demonacion("Perecederos")
                    .build();
            Categoria limpieza = Categoria.builder()
                    .demonacion("Limpieza")
                    .build();
            Categoria lacteos = Categoria.builder()
                    .demonacion("Lacteos ")
                    .build();
            Articulo articulo1 = Articulo.builder()
                    .denominacion("Harpic gel limpiador")
                    .cantidad(10)
                    .precio(3900)
                    .build();
            articulo1.getCategorias().add(limpieza);
            limpieza.getArticulos().add(articulo1);
            Articulo articulo2 = Articulo.builder()
                    .denominacion("manteca la serenisima ")
                    .precio(3000)
                    .build();
            articulo2.getCategorias().add(lacteos);
            lacteos.getArticulos().add(articulo2);
            Factura factura1 = Factura.builder()
                    .numero(1)
                    .fecha("04/09/24")
                    .cliente(cliente1)
                    .build();
            DetalleFactura detalle1 = DetalleFactura.builder()
                    .articulo(articulo1)
                    .cantidad(2)
                    .subtotal(7800)
                    .build();
            DetalleFactura detalle2 = DetalleFactura.builder()
                    .articulo(articulo2)
                    .cantidad(1)
                    .subtotal(3000)
                    .build();
            detalle2.setFactura(factura1);
            detalle1.setFactura(factura1);
            factura1.getDetalle().add(detalle1);
            factura1.getDetalle().add(detalle2);
            factura1.setTotal(10800);
            entityManager.persist(factura1);
            // Segunda Factura

            Domicilio domicilio2 = Domicilio.builder()
                    .nombreCalle("San Martin")
                    .numero(256)
                    .build();
            Cliente cliente2 = Cliente.builder()
                    .apellido("Mendez")
                    .nombre("Luis")
                    .dni(47896512)
                    .build();
            cliente2.setDomicilio(domicilio2);
            domicilio2.setCliente(cliente2);

            Articulo articulo3 = Articulo.builder()
                    .denominacion("Yogurt bebible")
                    .cantidad(15)
                    .precio(1800)
                    .build();
            articulo3.getCategorias().add(lacteos);
            lacteos.getArticulos().add(articulo3);

            Articulo articulo4 = Articulo.builder()
                    .denominacion("Lavandina Ayudin")
                    .precio(2200)
                    .build();
            articulo4.getCategorias().add(limpieza);
            limpieza.getArticulos().add(articulo4);

            Factura factura2 = Factura.builder()
                    .numero(2)
                    .fecha("06/09/24")
                    .cliente(cliente2)
                    .build();

            DetalleFactura detalle3 = DetalleFactura.builder()
                    .articulo(articulo3)
                    .cantidad(3)
                    .subtotal(5400)
                    .build();
            DetalleFactura detalle4 = DetalleFactura.builder()
                    .articulo(articulo4)
                    .cantidad(2)
                    .subtotal(4400)
                    .build();

            detalle3.setFactura(factura2);
            detalle4.setFactura(factura2);
            factura2.getDetalle().add(detalle3);
            factura2.getDetalle().add(detalle4);
            factura2.setTotal(9800);

            entityManager.persist(factura2);

// Tercer domicilio y cliente
            Domicilio domicilio3 = Domicilio.builder()
                    .nombreCalle("Belgrano")
                    .numero(1020)
                    .build();
            Cliente cliente3 = Cliente.builder()
                    .apellido("Gomez")
                    .nombre("Sofia")
                    .dni(49875231)
                    .build();
            cliente3.setDomicilio(domicilio3);
            domicilio3.setCliente(cliente3);

            Articulo articulo5 = Articulo.builder()
                    .denominacion("Queso rallado")
                    .cantidad(5)
                    .precio(2500)
                    .build();
            articulo5.getCategorias().add(lacteos);
            lacteos.getArticulos().add(articulo5);

            Articulo articulo6 = Articulo.builder()
                    .denominacion("Jabón en polvo")
                    .precio(2800)
                    .build();
            articulo6.getCategorias().add(limpieza);
            limpieza.getArticulos().add(articulo6);

// Tercera factura con los detalles
            Factura factura3 = Factura.builder()
                    .numero(3)
                    .fecha("07/09/24")
                    .cliente(cliente3)
                    .build();

            DetalleFactura detalle5 = DetalleFactura.builder()
                    .articulo(articulo5)
                    .cantidad(3)
                    .subtotal(7500)
                    .build();
            DetalleFactura detalle6 = DetalleFactura.builder()
                    .articulo(articulo6)
                    .cantidad(1)
                    .subtotal(2800)
                    .build();

            detalle5.setFactura(factura3);
            detalle6.setFactura(factura3);
            factura3.getDetalle().add(detalle5);
            factura3.getDetalle().add(detalle6);
            factura3.setTotal(10300);

            entityManager.persist(factura3);
            entityManager.flush();
            entityManager.getTransaction().commit();*/
            //Modificacion factura1
            Factura factura1 = entityManager.find(Factura.class,1L);
            factura1.setNumero(85);
            entityManager.merge(factura1);
            //Eliminacion factura1
            entityManager.remove(factura1);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }catch (Exception e){

            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar la clase Persona");}

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
