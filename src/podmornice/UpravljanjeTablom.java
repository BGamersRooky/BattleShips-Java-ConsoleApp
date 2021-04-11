/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package podmornice;

import java.io.IOException;

/**
 *
 * @author filip
 */
public interface UpravljanjeTablom {
        public String nacrtajTablu(Tabla t, boolean b) throws IOException, InterruptedException;    
        public boolean Shoot(Tabla t, String c, int[] life);
}
