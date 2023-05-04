<script lang="ts">
	import { AppBar } from '@skeletonlabs/skeleton'
</script>

<div>
	<AppBar>
		<svelte:fragment slot="lead">
			<i class="fa-solid fa-bars" />
		</svelte:fragment>

		<h1>Fanicon</h1>

		<svelte:fragment slot="trail">
			<i class="fa-solid fa-user" />
		</svelte:fragment>
	</AppBar>

	<div class="p-4">
		<slot />
	</div>
</div>
