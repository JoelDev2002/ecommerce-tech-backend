package pe.edu.idat.webtech.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "compra")
public class Compra
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long compraId;
    private BigDecimal total;
    private LocalDate fechaCompra;
    private String metodoPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "compra",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<DetalleCompra> detalleCompras;
}
