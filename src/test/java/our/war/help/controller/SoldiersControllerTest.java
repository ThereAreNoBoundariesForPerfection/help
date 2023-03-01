package our.war.help.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import our.war.help.exception.SoldierAlreadyExistsException;
import our.war.help.exception.SoldierNotFoundException;
import our.war.help.model.Soldier;
import our.war.help.repository.SoldierRepository;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

//@ExtendWith(MockitoExtension.class)
class SoldiersControllerTest {
//
//    @Mock
//    private SoldierRepository soldierRepository;
//
//    private MockMvc mockMvc;
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    void setUp() {
//        SoldiersController soldiersController = new SoldiersController(soldierRepository);
//        mockMvc = standaloneSetup(soldiersController).build();
//        objectMapper = new ObjectMapper();
//    }
//
//    @Test
//    void testNewSoldier() throws Exception {
//        Soldier soldier = new Soldier();
//        soldier.setEmail("test@test.com");
//
//        when(soldierRepository.findByEmail("test@test.com")).thenReturn(null);
//        doNothing().when(soldierRepository).save(any(Soldier.class));
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/soldiers")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(soldier)))
//                .andExpect(status().isOk());
//
//        doThrow(new SoldierAlreadyExistsException("The soldier with this email already exists"))
//                .when(soldierRepository).findByEmail("test@test.com");
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/soldiers")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(soldier)))
//                .andExpect(status().isConflict())
//                .andExpect(content().string("The soldier with this email already exists"));
//    }

//    @Test
//    void testUpdateSoldier() throws Exception {
//        Soldier soldier = new Soldier();
//        soldier.setId(1L);
//        soldier.setEmail("test@test.com");
//
//        when(soldierRepository.findById(1L)).thenReturn(Optional.of(soldier));
//        doNothing().when(soldierRepository).save(any(Soldier.class));
//
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/soldiers/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(soldier)))
//                .andExpect(status().isOk());
//
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/soldiers/2")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(soldier)))
//                .andExpect(status().isNotFound())
//                .andExpect(content().string("Soldier with this 2 not found"));
//    }

//    @Test
//    void testGetSoldierById() throws Exception {
//        Soldier soldier = new Soldier();
//        soldier.setId(1L);
//        soldier.setEmail("test@test.com");
//
//        when(soldierRepository.findById(1L)).thenReturn(Optional.of(soldier));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/soldiers/1");
//    }
}