import defaultSettings from '@/settings'

const title = defaultSettings.title || '太原理工大学奖助学金系统'

export default function getPageTitle(pageTitle) {
  if (pageTitle) {
    return `${pageTitle} - ${title}`
  }
  return `${title}`
}
