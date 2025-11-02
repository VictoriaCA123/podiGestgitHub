<script setup>
// Importa las funciones necesarias de Vue
import { ref, onMounted } from 'vue';
// Importa la función de llamada API que acabas de crear
import { getAllItems } from './api/itemApi';

// 1. Variable reactiva para almacenar la lista de ítems
const items = ref([]);
const cargando = ref(true);

// 2. Función que se ejecuta al cargar la página
onMounted(async () => {
  console.log('Iniciando carga de datos...');
 
  // Llama a la función API para obtener los datos del Backend
  items.value = await getAllItems();
  cargando.value = false;
 
  console.log('Datos recibidos y listos para mostrar:', items.value);
});
</script>

<template>
  <div class="container">
    <h1>Proyecto podiGest: Ítems Disponibles</h1>
   
    <p v-if="cargando">Cargando datos del Backend (Spring Boot)...</p>
   
    <div v-else-if="items.length === 0" class="error-message">
      No se pudieron cargar ítems. Asegúrate de que el Backend esté **ENCENDIDO** en http://localhost:8080.
    </div>
   
    <ul v-else class="item-list">
      <li v-for="item in items" :key="item.id" class="item-card">
        <h3>{{ item.nombre }}</h3>
        <p><strong>Autor:</strong> {{ item.autor }}</p>
        <p><strong>Duración:</strong> {{ item.duracion }} minutos</p>
      </li>
    </ul>
  </div>
</template>

<style scoped>
.container {
  max-width: 800px;
  margin: 0 auto;
  font-family: sans-serif;
  padding: 20px;
}
h1 { color: #35495e; }
.item-list {
  list-style: none;
  padding: 0;
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 20px;
}
.item-card {
  border: 1px solid #41b883; /* Color verde de Vue */
  padding: 15px;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}
.error-message {
  color: #ff0000;
  background-color: #ffe5e5;
  padding: 15px;
  border-radius: 4px;
}
</style>
