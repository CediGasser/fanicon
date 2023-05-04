<script lang="ts">
	import '@skeletonlabs/skeleton/themes/theme-skeleton.css'
	import '@skeletonlabs/skeleton/styles/all.css'

	import '../app.postcss'

	import Footer from './Footer.svelte'
</script>

<div>
	<slot />
	<Footer />
</div>

<style>
	div {
		min-height: 100%;
		display: grid;
		grid-template-rows: 1fr auto;
	}
</style>
