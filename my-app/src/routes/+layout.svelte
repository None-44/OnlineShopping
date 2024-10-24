<script>
	import Header from '$lib/Header.svelte';
	import Navbar from '$lib/Navbar.svelte';
	import Sidebar from '$lib/Sidebar.svelte';
	import Footer from '$lib/Footer.svelte';
  </script>
  
  <Header />
  <Navbar />
  
  <div style="display: flex;">
	<Sidebar />
	<main style="flex:1;font-size: 24px">
	  <slot />
	</main>

  </div>

  <Footer />
  