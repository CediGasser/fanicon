<script lang="ts">
	import type { IconsDesign } from '$lib/types'

	export let design: IconsDesign
	$: ({ rotation, gap, padding, background, size, name, icons } = design)

	$: designStyle = `
		--bg: ${background};
		--pad: ${padding}px;
		--size: ${size}px;
	`

	$: gridStyle = `
        --cols: ${icons[0].length};
        --gap: ${gap}px;
        --rotation: ${rotation}deg;
    `
</script>

<div class="design" style={designStyle}>
	<div class="grid-wrapper" style={gridStyle}>
		{#each icons as row}
			{#each row as icon}
				<div class="icon" dropzone>
					<svg
						xmlns="http://www.w3.org/2000/svg"
						class="icon"
						aria-hidden="true"
						focusable="false"
						viewBox="0 0 512 512"
					>
						<path
							fill="currentColor"
							d="M256 8C119 8 8 119 8 256s111 248 248 248 248-111 248-248S393 8 256 8zm0 448c-110.5 0-200-89.5-200-200S145.5 56 256 56s200 89.5 200 200-89.5 200-200 200zm61.8-104.4l-84.9-61.7c-3.1-2.3-4.9-5.9-4.9-9.7V116c0-6.6 5.4-12 12-12h32c6.6 0 12 5.4 12 12v141.7l66.8 48.6c5.4 3.9 6.5 11.4 2.6 16.8L334.6 349c-3.9 5.3-11.4 6.5-16.8 2.6z"
						/>
					</svg>
				</div>
			{/each}
		{/each}
	</div>
</div>

<style>
	.design {
		display: flex;
		align-items: center;
		justify-content: center;
		background: var(--bg);
		padding: var(--pad);
		border-radius: 1rem;
		aspect-ratio: 1 / 1;
		width: var(--size);
	}

	.grid-wrapper {
		display: grid;
		grid-template-columns: repeat(var(--cols, 3), 1fr);
		grid-gap: var(--gap);
		transform: rotate(var(--rotation));
		width: 100%;
	}

	div.icon {
		aspect-ratio: 1 / 1;
		display: flex;
		justify-content: center;
		align-items: center;
		color: var(--icon-color, #fff);
	}
</style>
