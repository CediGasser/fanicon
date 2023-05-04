<script lang="ts">
	import Editor from '$lib/components/Editor.svelte'
	import IconDrawer from './IconDrawer.svelte'

	import type { IconsDesign, Icon } from '$lib/types'

	export let data

	let icons: Icon[][] = [
		[
			{ src: 'api/icons/fi-tr-angry.svg', color: 'red' },
			{ src: 'api/icons/fi-tr-octagon.svg', color: 'blue', rotate: 45 },
			{ src: 'api/icons/globe.svg', color: 'green' },
			{ src: 'api/icons/home.svg', size: 0.5, color: 'yellow' },
			{ src: 'api/icons/fi-tr-angry.svg', color: 'red' },
			{ src: 'api/icons/fi-tr-octagon.svg', color: 'blue', rotate: 45 },
			{ src: 'api/icons/globe.svg', color: 'green' },
			{ src: 'api/icons/home.svg', size: 0.5, color: 'yellow' }
		],
		[
			{ src: 'api/icons/fi-tr-angry.svg', color: '#fd83ec' },
			{ src: 'api/icons/fi-tr-octagon.svg', color: 'firebrick', rotate: 45 },
			{ src: 'api/icons/globe.svg', color: 'slategrey' },
			{ src: 'api/icons/home.svg', size: 0.5, color: 'lightgreen' },
			{ src: 'api/icons/fi-tr-angry.svg', color: 'cyan' },
			{ src: 'api/icons/fi-tr-octagon.svg', color: 'black', rotate: 45 },
			{ src: 'api/icons/globe.svg', color: 'white' },
			{ src: 'api/icons/home.svg', size: 0.5, color: 'yellow' }
		]
	]

	let design = {
		rotation: 0,
		gap: 16,
		padding: 8,
		background: 'linear-gradient(45deg, #ff0000 0%, #0000ff 100%)',
		size: 300,
		name: 'Untitled',
		icons: [
			['fa-pen-to-square', 'fa-pen-nib', 'fa-fire-flame-curved'],
			['fa-pen-to-square', 'fa-pen-nib', 'fa-fire-flame-curved'],
			['fa-pen-to-square', 'fa-pen-nib', 'fa-fire-flame-curved'],
			['fa-pen-to-square', 'fa-pen-nib', 'fa-fire-flame-curved']
		]
	}
</script>

<h1>Design</h1>
<Editor {design} />
<IconDrawer iconSources={data.icons} />
