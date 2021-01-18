package org.upskill.listatarefas.model;

import java.util.ArrayList;
import java.util.List;

public enum Prioridade {
    BAIXA {
        public String toString() {
            return "Baixa";
        }
    },
    ABAIXO_NORMAL {
        public String toString() {
            return "Abaixo do Normal";
        }
    },
    NORMAL {
        public String toString() {
            return "Normal";
        }
    },
    ACIMA_NORMAL {
        public String toString() {
            return "Acima do Normal";
        }
    },
    ELEVADO {
        public String toString() {
            return "Elevado";
        }
    },
    TEMPO_REAL {
        public String toString() {
            return "Tempo Real";
        }
    };

    public static Prioridade[] getPrioridades() {
        List<Prioridade> arrlist
                = new ArrayList<Prioridade>();
        
        for (Prioridade prio : Prioridade.values()) {
            arrlist.add(prio);
        }
        
        Prioridade array[] = new Prioridade[]{};
        
        array = arrlist.toArray(array);
        
        return array;
    }

}
