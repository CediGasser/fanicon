<script lang="ts">
	export let iconSources: string[] = []
</script>

<div class="icons">
	{#each iconSources as src}
		<div draggable class="icon">
			<img {src} alt={src.split('/').pop()?.split('.').shift()} />
		</div>
	{/each}
</div>

<style>
	.icons {
		display: grid;
		grid-template-columns: repeat(auto-fill, minmax(100px, 1fr));
		grid-gap: 8px;
	}

	.icon {
		width: 100px;
		height: 100px;
		margin: 8px;
		border-radius: 8px;
		overflow: hidden;
		box-shadow: 0 0 16px 1px #000;
		padding: 8px;
	}

	.icon img {
		width: 100%;
		height: 100%;
		object-fit: contain;
	}
</style>
