import Ejemplo.*;
import java.util.*;

public class ConsultorioImpl extends ConsultorioPOA{
    private String doctores[];
    private ArrayList horarios[];
    
    public ConsultorioImpl()
    {
        doctores = new String[]{"doc1","doc2","doc3"};
        horarios = new ArrayList[]{new ArrayList() , new ArrayList() , new ArrayList()};
    }
    
    @Override
    public String agendarConsulta(String doctor, String horario) {
        int index = -1;
        String salida = "";
        
        for (int i = 0; i < doctores.length; i++) {
            if(doctores[i].equals(doctor)){
                index = i;
                break;
            }
        }
        
        if(index != -1)
        {
           if(horarios[index].isEmpty())
            {
                horarios[index].add(horario);
                salida = "Su cita ya esta agendada!";
            }else
            {
                boolean band = false;
                ListIterator hrs = horarios[index].listIterator();

                while(hrs.hasNext())
                {
                    if(hrs.next().equals(horario))
                    {
                        band = true;
                        break;
                    }
                }

                if(band)
                    salida = "Ese horario esta ocupado :v...";
                else
                {
                  horarios[index].add(horario);
                  salida = "Su cita esta agendada";
                }
            }
        }else
            salida = "No existe ese doctor :'V";
        
        return salida;
    }
    
}
