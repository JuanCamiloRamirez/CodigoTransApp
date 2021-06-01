package com.parcial.codigotransapp.services;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import com.parcial.codigotransapp.R;
import com.parcial.codigotransapp.adapter.CodigoTransAdapter;
import com.parcial.codigotransapp.model.CodigoTrans;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CodigoTransitoFragment extends AppCompatActivity {

    @BindView(R.id.listViewCodigos)
    ListView listViewCodigos;
    @BindView(R.id.editText)
    EditText editText;

    CodigoTransAdapter codigoTransAdapter;

    private List<CodigoTrans> codigoTrans;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_transito);
        ButterKnife.bind(this);
        loadInformation();
        codigoTransAdapter = new CodigoTransAdapter(this, codigoTrans);
        listViewCodigos.setAdapter(codigoTransAdapter);
        editTextWatcher();
    }

    private void editTextWatcher() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                 codigoTransAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void loadInformation(){
        codigoTrans = new ArrayList<>();
        codigoTrans.add(new CodigoTrans("A-1",4,"Por no transitar por la derecha de la vía","$ 117.040"));
        codigoTrans.add(new CodigoTrans("A-10",4,"Conducir por zonas de protección y seguridad o por vía férrea","$ 117.040"));
        codigoTrans.add(new CodigoTrans("A-11",4,"Transitar por zonas restringidas (El automotor será inmovilizado)","$ 117.040"));
        codigoTrans.add(new CodigoTrans("A-12",4,"Prestar servicio público con este tipo de vehículos","$ 117.040"));
        codigoTrans.add(new CodigoTrans("A-2",4,"Agarrarse de otro automotor en pleno movimiento","$ 117.040"));
        codigoTrans.add(new CodigoTrans("A-3",4,"Transportar cosas que disminuyan la visibilidad al conducir","$ 117.040"));
        codigoTrans.add(new CodigoTrans("A-4",4,"Transitar por andenes, ceras, puentes, ciclovías","$ 117.040"));
        codigoTrans.add(new CodigoTrans("A-5",4,"Irrespetar la señales de tránsito","$ 117.040"));
        codigoTrans.add(new CodigoTrans("A-7",4,"Transitar con dispositivos en estado defectuoso","$ 117.040"));
        codigoTrans.add(new CodigoTrans("A-8",4,"Transitar con su automotor por zonas prohibidas","$ 117.040"));
        codigoTrans.add(new CodigoTrans("A-9",4,"Realizar adelantamiento entre 2 vehículos que tengan sus respectivos carriles","$ 117.040"));
        codigoTrans.add(new CodigoTrans("B-1",8,"Conducir un vehículo sin portar la licencia","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-10",8,"Conducir un vehículo con vidrios polarizados u oscurecidos","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-11",8,"Conducir un vehículo con publicidad en los vidrios","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-12",8,"No respetar el tránsito ni las normas al conducir cortejos fúnebres","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-13",8,"No respetar las formaciones de tropas, la marcha de desfiles, procesiones, entierros, filas estudiantiles,&nbsp; manifestaciones públicas, etc.","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-14",8,"Remolcar otro vehículo","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-15",8,"Conducir un automotor de servicio público, y que en éste no se establezcan las tarifas oficiales","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-16",8,"Permitir que en un vehículo de servicio público para transporte de pasajeros se lleven animales u objetos que incomoden a los pasajeros","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-17",8,"Abandonar pasajeros en caso de tener un vehículo de transporte público","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-18",8,"No transitar por el carril derecho en transporte público (Cuando se transita sin pasajeros)","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-19",8,"Realizar la carga y descarga en zonas prohibidas o horarios restringidos","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-2",8,"Conducir, portar y presentar una licencia vencida","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-20",8,"Transportar carnes, pescado o alimentos altamente corruptibles","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-21",8,"Realizar la limpieza del vehículo en vías públicas, ríos, quebradas, etc","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-22",8,"Transitar con niños menores de 10 años en asientos delanteros","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-23",8,"Utilizar radios, equipos de sonido o de amplificación a volumenes que superan los decibeles máximos establecidos","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-3",8,"Conducir un vehículo sin placas o adulteradas; portarlas con obstáculos o en condiciones que dificulten su plena identificación","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-4",8,"Conducir un vehículo con placas adulteradas o retocadas","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-5",8,"Conducir un vehículo que porte una sola placa","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-6",8,"Conducir vehículos con placas falsas. En muchos casos el vehículo será inmobilizado","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-7",8,"No informas previamente ante un cambio de motor o color de un vehículo","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-8",8,"No pagar el peaje en lugares dispuestos","$ 234.080"));
        codigoTrans.add(new CodigoTrans("B-9",8,"Utilizar dispositivos o volumen que incomode a los pasajeros","$ 234.080"));
        codigoTrans.add(new CodigoTrans("C-1",15,"Portar y presentar licencia de conducción adulterada","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-10",15,"Transitar un automotor con las puertas abiertas","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-11",15,"No portal el equipo de seguridad o prevención","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-12",15,"Proveer combustible a un vehículo con el motor encendido o con pasajeros a bordo","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-13",15,"Transitar con un vehículo sin las adaptaciones obligatorias","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-14",15,"Conducir por zonas prohibidas o a horas restringidas","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-15",15,"Exceder la capacidad autorizada en su licencia","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-16",15,"Conducir un vehículo escolar sin el permiso ni la licencia respectiva","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-17",15,"Circular con combinaciones de vehículos de 2 o más unidades remolcadas","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-18",15,"Vehículos públicos con taxímetro adulterado, sellos rotos o adulterados","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-19",15,"Recoger o dejar pasajeros en lugares no autorizados","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-2",15,"Parquear un vehículo en zonas prohibidas","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-20",15,"Conducir un vehículo de carga en que se transporten materiales de construcción&nbsp;&nbsp;o a granel sin las medidas de protección, higiene y seguridad ordenadas","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-21",15,"No asegurar objetos que puedan causar un accidente en la vía","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-22",15,"Transitar cargas superiores a las autorizadas","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-23",15,"Impartir en vías públicas enseñanza practica para conducir sin estar autorizado","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-24",15,"Conducir motocicleta sin respetar las normas","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-25",15,"Transitar por el carril izquierdo a velocidad que entorpezca el tránsito (En caso de haber más carriles disponibles)","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-26",15,"Transitar en vehículos de 3.5 o más toneladas por el carril izquierdo (En caso de haber más carriles disponibles)","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-27",15,"Transitar con cargas, pasajeros que disminuyan la visibilidad del conductor","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-28",15,"Hacer uso de sirenas, luces intermitentes, o de alta intensidad sin estar autorizados","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-29",15,"Conducir a velocidad superior a la permitida","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-3",15,"Bloquear una calzada con un vehículo (También con intersección)","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-30",15,"No respetar la señal de ceda el paso","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-31",15,"No respetar los requerimiento en vías establecidos por agentes de tránsito","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-32",15,"No respetar el paso de peatones","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-33",15,"Poner un automotor en marcha sin las precauciones para evitar accidentes","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-34",15,"Repara un vehículo en vías públicas sin atender el procedimiento señalado","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-35",15,"No realizar la revisión tecnicomecánica en los tiempos establecidos","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-36",15,"Transportar carga en contenedores sin los dispositivos especiales de sujeción. El vehículo será inmovilizado","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-37",15,"Transportar personas en zonas prohibidas del automotor","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-38",15,"Usar un teléfono en el momento de transitar con su vehículo","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-39",15,"Vulnerar reglas de parqueo establecidas en el Artículo 77","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-4",15,"Estacionar un automotor sin respetar las debidas precauciones","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-40",15,"Conductores que estacionen en lugares aptos únicamente para conductores con discapacidad","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-5",15,"No reducir la velocidad según lo indicado por este código, cuando transite por un cruce escolar en los horarios y días de funcionamiento de la institución educativa.","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-6",15,"No utilizar el cinturón de seguridad (Tanto para el conductor como para los pasajeros)","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-7",15,"No utilizar las luces direccionales cuando deba hacerlo","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-8",15,"Transitar sin los dispositivos luminosos requeridos","$ 438.900"));
        codigoTrans.add(new CodigoTrans("C-9",15,"No respetar las señales de detención en el cruce de una línea férrea a una distancia mínima de 5 metros","$ 438.900"));
        codigoTrans.add(new CodigoTrans("D-1",30,"Guiar un vehículo sin autorización ni licencia vigente","$ 877.800"));
        codigoTrans.add(new CodigoTrans("D-10",30,"Conducir un vehículo de transporte escolar y superar los límites de velocidad","$ 877.800"));
        codigoTrans.add(new CodigoTrans("D-11",30,"Permitir el servicio público de pasajeros que no tenga la salida de emergencia en cada uno de sus costados adicionalmente a las puertas de ascenso de pasajeros","$ 877.800"));
        codigoTrans.add(new CodigoTrans("D-12",30,"Destinar un vehículo a servicios diferentes establecidos en la licencia","$ 877.800"));
        codigoTrans.add(new CodigoTrans("D-13",30,"Transportar carga con peso superior al autorizado","$ 877.800"));
        codigoTrans.add(new CodigoTrans("D-14",30,"Vehículos que usen para su movilización combustibles no regulados como gas propano u otros que pongan en peligro la vida de peatones","$ 877.800"));
        codigoTrans.add(new CodigoTrans("D-15",30,"Cambio del recorrido o trazado de la ruta para vehículo de servicio","$ 877.800"));
        codigoTrans.add(new CodigoTrans("D-16",30,"Arrojar basura o residuos sólidos al espacio público","$ 877.800"));
        codigoTrans.add(new CodigoTrans("D-11",30,"Transitar sin los dispositivos luminosos requeridos","$ 877.800"));
        codigoTrans.add(new CodigoTrans("D-11",30,"Transitar sin los dispositivos luminosos requeridos","$ 877.800"));
        codigoTrans.add(new CodigoTrans("D-11",30,"Transitar sin los dispositivos luminosos requeridos","$ 877.800"));
        codigoTrans.add(new CodigoTrans("D-11",30,"Transitar sin los dispositivos luminosos requeridos","$ 877.800"));
        codigoTrans.add(new CodigoTrans("D-11",30,"Transitar sin los dispositivos luminosos requeridos","$ 877.800"));



    }

}